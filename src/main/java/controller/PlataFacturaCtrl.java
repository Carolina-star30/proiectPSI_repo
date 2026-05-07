package controller;

import repository.AbstractRepository;
import repository.MasterRepository;
import repository.PlataRepository;
import model.Plata;
import model.Factura;
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
        plataRepo.beginTransaction();
        try {
            Plata plataNoua = new Plata();
            plataNoua.setFactura(adapter.getFacturaSelectata());
            plataNoua.setSumaPlata(adapter.getSumaPlata());
            plataNoua.setDatPlatii(new Date());
            plataNoua.setContBancar((adapter.getBancaSelectata().getNumeBanca()));

            //apelam metida din repository
            plataRepo.proceseazaPlata(plataNoua, adapter.getFacturaSelectata());
            plataRepo.commitTransaction();
            System.out.println("Plata realizata cu succes!");
        }catch (Exception e){
            plataRepo.rollbackTransaction();
            System.err.println("Eroare la plata: "+ e.getMessage());
        }
    }
}
