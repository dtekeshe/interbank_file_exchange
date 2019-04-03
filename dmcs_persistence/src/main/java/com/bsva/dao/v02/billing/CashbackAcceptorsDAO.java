package com.bsva.dao.v02.billing;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.billing.CashbackAcceptorEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Document
 */
public class CashbackAcceptorsDAO extends AbstractDao<CashbackAcceptorEntity, Void> {

    private final static String CASHBACK_ACCEPTORS_SQL =
            "   SELECT CB_MCC                                                                                       " +
            "     FROM CSF_CASHBACK_MCC                                                                             ";

    public List<Integer> cashbackAcceptor() {

        List<CashbackAcceptorEntity> entities
                = list(CASHBACK_ACCEPTORS_SQL, CashbackAcceptorEntity.class);

        List<Integer> cashbackAcceptos = new ArrayList<>();
        for (CashbackAcceptorEntity entity : entities) {
            cashbackAcceptos.add(entity.getCbMcc());
        }

        return cashbackAcceptos;
    }
}
