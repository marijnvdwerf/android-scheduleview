package nl.marijnvdwerf.scheduleview.example;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import nl.marijnvdwerf.scheduleview.widget.ScheduleAdapter;
import nl.marijnvdwerf.scheduleview.widget.ScheduleView;

public class ExampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ExampleEvent> events = new ArrayList<ExampleEvent>();
        DateTime now = DateTime.now();

        events.add(new ExampleEvent("A", DateTime.now().withTime(8, 0, 0, 0), DateTime.now().withTime(9, 30, 0, 0)));
        events.add(new ExampleEvent("B", DateTime.now().withTime(9, 0, 0, 0), DateTime.now().withTime(11, 0, 0, 0)));
        events.add(new ExampleEvent("C", DateTime.now().withTime(10, 0, 0, 0), DateTime.now().withTime(12, 0, 0, 0)));

        events.add(new ExampleEvent("D", DateTime.now().withTime(14, 0, 0, 0), DateTime.now().withTime(16, 0, 0, 0)));
        events.add(new ExampleEvent("E", DateTime.now().withTime(14, 0, 0, 0), DateTime.now().withTime(16, 0, 0, 0)));
        events.add(new ExampleEvent("F", DateTime.now().withTime(14, 0, 0, 0), DateTime.now().withTime(16, 0, 0, 0)));

        ScheduleView scheduleView = (ScheduleView) findViewById(R.id.schedule);
        scheduleView.setAdapter(new ExampleAdapter(this, events));
    }

    static class ExampleAdapter extends ScheduleAdapter {

        private LayoutInflater mInflater;
        private List<ExampleEvent> mEvents;

        public ExampleAdapter(Context context, List<ExampleEvent> events) {
            mInflater = LayoutInflater.from(context);
            mEvents = events;
        }

        @Override
        public int getCountForDate(DateTime date) {
            return mEvents.size();
        }

        @Override
        public ExampleEvent getEvent(int position) {
            return mEvents.get(position);
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_event, viewGroup, false);
            }

            ExampleEvent event = getEvent(i);

            TextView eventId = (TextView) convertView.findViewById(R.id.event_id);
            eventId.setText(event.getId());

            TextView eventStart = (TextView) convertView.findViewById(R.id.event_start);
            eventStart.setText(event.getStartDateTime().toString("H:mm"));

            TextView eventEnd = (TextView) convertView.findViewById(R.id.event_end);
            eventEnd.setText(event.getEndDateTime().toString("H:mm"));

            return convertView;
        }
    }

    private static class ExampleEvent implements ScheduleAdapter.ScheduleEvent {

        private String mId;
        private DateTime mStartDateTime;
        private DateTime mEndDateTime;

        private ExampleEvent(String id, DateTime startDateTime, DateTime endDateTime) {
            mId = id;
            mStartDateTime = startDateTime;
            mEndDateTime = endDateTime;
        }

        @Override
        public String getId() {
            return mId;
        }

        @Override
        public DateTime getStartDateTime() {
            return mStartDateTime;
        }

        @Override
        public DateTime getEndDateTime() {
            return mEndDateTime;
        }
    }
}
