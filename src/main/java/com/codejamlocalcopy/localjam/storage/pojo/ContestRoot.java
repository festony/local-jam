package com.codejamlocalcopy.localjam.storage.pojo;

import java.util.Date;
import java.util.List;

/**
 * Created by festony on 23/02/18.
 */
public class ContestRoot {
    public class Tab {
        public class Tournament {
            public class Contest {
                public String startDate;
                public String name;
                public Boolean analysis;
                public Date startDateTime;
                public String duration;
                public String id;
            }
            public List<Contest> contests;
            public String grouping;
            public String name;
            public Date lastContestStart;
            public String displayLanguage;
        }
        public int order;
        public List<Tournament> tournaments;
        public String id;
        public String label;
    }
    public List<Tab> tabs;
    public String contestsText;
}
