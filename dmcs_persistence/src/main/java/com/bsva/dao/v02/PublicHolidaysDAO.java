package com.bsva.dao.v02;

import com.bsva.dao.AbstractDao;
import com.bsva.entities.v02.params.PublicHolidayEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO Document
 */
public class PublicHolidaysDAO extends AbstractDao<PublicHolidayEntity, Void> {

    public final static String PUBLIC_HOLIDAY_SQL =
            "   SELECT PROCESS_DATE AS CALENDAR_DATE " +
            "     FROM CSF_PUBLIC_HOLIDAYS " +
            "    WHERE PUBLIC_HOLIDAY_INDICATOR = 'Y' ";

    public List<java.util.Date> publicHolidays() {

        // execute
        List<PublicHolidayEntity> entities = list(PUBLIC_HOLIDAY_SQL, PublicHolidayEntity.class);

        // prepare result
        List<java.util.Date> dates = new ArrayList<>();
        for (PublicHolidayEntity entity : entities) {
            dates.add(entity.getCalendarDate());
        }

        return dates;
    }
}
