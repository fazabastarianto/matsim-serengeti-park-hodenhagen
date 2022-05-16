package org.matsim.analysis;

import org.matsim.core.events.EventsUtils;

public class simpleAnalysis {

    public static void main(String[] args) {

        var handler = new SimplePersonEventHandler();
        var manager = EventsUtils.createEventsManager();
                manager.addHandler(handler);

        EventsUtils.readEvents(manager,"/Users/fazafawzan/git/matsim-serengeti-park-hodenhagen/scenarios/serengeti-park-v1.0/output/output-serengeti-park-v1.0-run1/serengeti-park-v1.0-run1.output_events.xml.gz");


    }
}
