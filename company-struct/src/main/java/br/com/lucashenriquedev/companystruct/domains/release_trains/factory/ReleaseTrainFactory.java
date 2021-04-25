package br.com.lucashenriquedev.companystruct.domains.release_trains.factory;

import br.com.lucashenriquedev.companystruct.domains.release_trains.model.ReleaseTrain;

public class ReleaseTrainFactory {

    public static ReleaseTrain create(Long id) {
        if (id == null) {
            return null;
        }

        var responsible = new ReleaseTrain();
        responsible.setId(id);

        return responsible;
    }

}
