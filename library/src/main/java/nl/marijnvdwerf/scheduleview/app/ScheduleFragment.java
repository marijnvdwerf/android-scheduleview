package nl.marijnvdwerf.scheduleview.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nl.marijnvdwerf.scheduleview.R;
import nl.marijnvdwerf.scheduleview.widget.ScheduleView;

public class ScheduleFragment extends Fragment {

    ScheduleView mSchedule;

    public ScheduleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_schedule,
                container, false);
    }

    /**
     * Attach to list widget once the widget hierarchy has been created.
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSchedule = (ScheduleView) view.findViewById(R.id.schedule);
    }

    /**
     * Detach from list widget.
     */
    @Override
    public void onDestroyView() {
        mSchedule = null;
        super.onDestroyView();
    }

    /**
     * Get the activity's list widget widget.
     */
    public ScheduleView getScheduleView() {
        return mSchedule;
    }
}
