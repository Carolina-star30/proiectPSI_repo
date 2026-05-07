package controller;

import repository.AbstractRepository;
import repository.MasterRepository;
import repository.PlataRepository;
import model.Plata;
import model.Factura;
import model.Furnizor;
import java.util.Date;

public class PlataFacturaCtrl {

    private PlataFacturaAdapter adapter;
    private MasterRepository masterRepo;
    private PlataRepository plataRepo;

    public PlataFacturaCtrl() {
        this.adapter = new PlataFacturaAdapter();
        this.masterRepo = new MasterRepository();
        this.plataRepo = new PlataRepository();

    }

    //cand se deschide formularul se incarca listele de baza
    public void initFormular() {
        adapter.setListaBanci(masterRepo.findAllBanci());
        adapter.setListaFurnizori(masterRepo.findAllFurnizori());
    }

    //cand selectam un furnizor aducem doar facturile neachitate ale acestuia
    public void onFurnizorChanged() {
        if (adapter.getFurnizorSelectat() != null) {
            Long idFurnizor = adapter.getFurnizorSelectat().getId();
            adapter.setListaFacturiNeachitate(plataRepo.findFacturiNeachitateByFurnizor(idFurnizor));

            System.out.println("S-au încărcat datele pentru furnizorul: " + adapter.getFurnizorSelectat().getNume());
        }
    }

    //cand se selecteaza o factura completam automat suma de plata pe ecran cu restul ramas
    public void onFacturaSelected() {
        if (adapter.getFacturaSelectata() != null) {
            adapter.setSumaPlata(adapter.getFacturaSelectata().getRestPlata());
        }
    }

    //salvare in baza de date
    public void executaPlata() {

        if (adapter.getFacturaSelectata() == null || adapter.getSumaPlata() == null) {
            System.err.println("Eroare: Nu s-a selectat factura sau suma!");
            return;
        }
        plataRepo.beginTransaction();

        try {

            Factura facturaDePlatit = adapter.getFacturaSelectata();
            Double sumaPlatita = adapter.getSumaPlata();

            Plata plataNoua = new Plata();
            plataNoua.setFactura(facturaDePlatit);
            plataNoua.setSumaPlata(sumaPlatita);
            plataNoua.setDataDocument(adapter.getDataPlatii());
            plataNoua.setContBancar((adapter.getBancaSelectata().getNumeBanca()));
            plataNoua.setReferinta(adapter.getReferintaExtras());

            double noulRest = facturaDePlatit.getRestPlata() - sumaPlatita;
            facturaDePlatit.setRestPlata(noulRest);

            if (noulRest <= 0) {
                facturaDePlatit.setStatusFactura("Achitata");
            } else {
                facturaDePlatit.setStatusFactura("Achitata partial");
            }

            Furnizor furnizorDeActualizat = facturaDePlatit.getFurnizor();

            double soldCurent = furnizorDeActualizat.getSold() != null ? furnizorDeActualizat.getSold() : 0.0;

            // Scădem suma plătită din datoria totală
            furnizorDeActualizat.setSold(soldCurent - sumaPlatita);

            // Apelăm metoda din repository (ATENȚIE: am adăugat și furnizorul ca parametru)
            plataRepo.proceseazaPlata(plataNoua, facturaDePlatit, furnizorDeActualizat);
            plataRepo.commitTransaction();
            System.out.println("Plata a fost înregistrată. Status factură: " + facturaDePlatit.getStatusFactura());
        }catch (Exception e){
            plataRepo.rollbackTransaction();
            System.err.println("Eroare la procesarea plății: "+ e.getMessage());
        }
    }
}
