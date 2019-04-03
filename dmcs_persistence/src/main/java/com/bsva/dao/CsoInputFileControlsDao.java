package com.bsva.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bsva.dto.FileStatusDTO;
import com.bsva.entities.CsoInputFileControls;

/**
 * @author AugustineA
 *
 */
public class CsoInputFileControlsDao extends AbstractDao<CsoInputFileControls, Long> {

    public CsoInputFileControlsDao() {
        super();
    }

    /**
     * Insert a new Event into the database.
     *
     * @param csoInputFileControls
     */
    public void create(CsoInputFileControls csoInputFileControls) {
        super.saveOrUpdate(csoInputFileControls);
    }

    /**
     * Delete a detached Event from the database.
     *
     * @param csoInputFileControls
     */
    public void delete(CsoInputFileControls csoInputFileControls) {
        super.delete(csoInputFileControls);
    }

    /**
     * Find an Event by its primary key.
     *
     * @param longl
     * @return
     */
    public CsoInputFileControls find(Long longl) {
        return (CsoInputFileControls) super.find(CsoInputFileControls.class, longl);
    }

    /**
     * Updates the state of a detached Event.
     *
     * @param csoInputFileControls
     */
    public void update(CsoInputFileControls csoInputFileControls) {
        super.saveOrUpdate(csoInputFileControls);
    }

    /**
     * Finds all Events in the database.
     *
     * @return
     */
    public List findAll() {
        return super.findAll(CsoInputFileControls.class);
    }
    
  /*  public List executeTypeQuerySQL(Set<String> quer, String string) { 
    	
    	return super.executeQueryParametersNativeSQL(quer,string);
    }*/

    @Override
    public CsoInputFileControls executeQueryParametersSingle(String query, Map<String, Object> parameters) {
        return super.executeQueryParametersSingle(query, parameters);
    }

    public FileStatusDTO getFileStatus(String fileReferenceNumber) {
        String hql = "select c from CsoInputFileControls c where c.fileRefNumber = :fileRefNumber";
        Map<String, Object> params = new HashMap<>();
        params.put("fileRefNumber", fileReferenceNumber);
        CsoInputFileControls fileControls = executeSQLQuery(hql, params, CsoInputFileControls.class);

        FileStatusDTO.FileProcessStatus processStatus = FileStatusDTO.FileProcessStatus.getByStatusCode(fileControls.getProcessStatus());

        FileStatusDTO dto = new FileStatusDTO(processStatus, fileControls.getIsBilled(), fileControls.getIsPreExtracted());
        return dto;
    }

    /*public int updateFileStatus(String fileReferenceNumber, FileStatusDTO fileStatus) {
        String hql = " update CsoInputFileControls " +
                     "    set   processStatus = :processStatus " +
                                (fileStatus.isBilled() != null ? ", billed = :billed " : "") +
                                (fileStatus.isPreExtracted() != null ? ", preExtracted = :preExtracted " : "") +
                     "  where fileRefNumber = :fileRefNumber";
        Map<String, Object> params = new HashMap<>();
        params.put("processStatus", fileStatus.getFileProcessStatus().getStatusCode());
        params.put("fileRefNumber", fileReferenceNumber);
        if (fileStatus.isBilled() != null) {
            params.put("billed", fileStatus.isBilled() ? "Y" : "N");
        }
        if (fileStatus.isPreExtracted() != null) {
            params.put("preExtracted", fileStatus.isPreExtracted() ? "Y" : "N");
        }

        int result = update(hql, params);

        return result;
    }*/
}
