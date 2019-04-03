package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.params.ScheduleTimeEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO Document
 */
public class ScheduledTimesDAO extends AbstractDao<ScheduleTimeEntity, Void> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:SS");

    private final static String SCHEDULED_TIMES_SQL =
            " SELECT SUB_SERVICE, START_TIME, NVL(END_TIME, '23:59:59') AS END_TIME, ACTIVE_IND " +
            "   FROM CSF_SCHEDULE_TIMES" +
            "  WHERE SERVICE = 'CARD'" +
            "    AND SUB_SERVICE = :subServiceID " +
            "    AND PROCESS = :processName ";

    public Boolean isActivate(String subServiceID, String processName) throws ParseException {

        // prepare params
        Map<String, Object> params = new HashMap<>();
        params.put("subServiceID", subServiceID);
        params.put("processName", processName);

        // execute
        ScheduleTimeEntity scheduleTime
                = uniqueResult(SCHEDULED_TIMES_SQL, params, ScheduleTimeEntity.class);

        String currentTimeString = DATE_FORMAT.format(new Date());
        Date currentTime = DATE_FORMAT.parse(currentTimeString);
        Date startTime = DATE_FORMAT.parse(scheduleTime.getStartTimeString());
        Date endTime = DATE_FORMAT.parse(scheduleTime.getEndTimeString());

        String activeInd = scheduleTime.getActiveIndicatorString();

        return currentTime.after(startTime) && currentTime.before(endTime) && "Y".equals(activeInd);
    }
}
