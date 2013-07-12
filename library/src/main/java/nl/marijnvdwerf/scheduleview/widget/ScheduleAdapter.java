package nl.marijnvdwerf.scheduleview.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.joda.time.DateTime;

public abstract class ScheduleAdapter extends BaseAdapter {

    @Override
    public final boolean hasStableIds() {
        return true;
    }

    @Override
    public final Object getItem(int i) {
        return null;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final View getDropDownView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public final boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public final int getCount() {
        return -1;
    }

    @Override
    public final long getItemId(int i) {
        return -1;
    }

    public abstract int getCountForDate(DateTime date);

    public abstract ScheduleEvent getEvent(int position);

    public static interface ScheduleEvent {
        public String getId();

        public DateTime getStartDateTime();

        public DateTime getEndDateTime();
    }
}
