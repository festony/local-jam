package com.codejamlocalcopy.localjam.storage.pojo;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

                @Override
                public boolean equals(Object other) {
                    if (other == this) {
                        return true;
                    }
                    if (other == null || !(other instanceof Contest)) {
                        return false;
                    }
                    Contest otherContest = (Contest) other;
                    return Objects.equal(startDate, otherContest.startDate)
                            && Objects.equal(name, otherContest.name)
                            && Objects.equal(analysis, otherContest.analysis)
                            && Objects.equal(startDateTime, otherContest.startDateTime)
                            && Objects.equal(duration, otherContest.duration)
                            && Objects.equal(id, otherContest.id);
                }

                @Override
                public int hashCode() {
                    return new HashCodeBuilder()
                            .append(startDate)
                            .append(name)
                            .append(analysis)
                            .append(startDateTime)
                            .append(duration)
                            .append(id)
                            .toHashCode();
                }
            }

            public List<Contest> contests;
            public String grouping;
            public String name;
            @SerializedName("last_contest_start")
            public Date lastContestStart;
            @SerializedName("display_language")
            public String displayLanguage;

            @Override
            public boolean equals(Object other) {
                if (other == this) {
                    return true;
                }
                if (other == null || !(other instanceof Tournament)) {
                    return false;
                }
                Tournament otherTournament = (Tournament) other;
                return Objects.equal(contests, otherTournament.contests)
                        && Objects.equal(grouping, otherTournament.grouping)
                        && Objects.equal(name, otherTournament.name)
                        && Objects.equal(lastContestStart, otherTournament.lastContestStart)
                        && Objects.equal(displayLanguage, otherTournament.displayLanguage);
            }

            @Override
            public int hashCode() {
                return new HashCodeBuilder()
                        .append(contests)
                        .append(grouping)
                        .append(name)
                        .append(lastContestStart)
                        .append(displayLanguage)
                        .toHashCode();
            }
        }

        public int order;
        public List<Tournament> tournaments;
        public String id;
        public String label;

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (other == null || !(other instanceof Tab)) {
                return false;
            }
            Tab otherTab = (Tab) other;
            return Objects.equal(order, otherTab.order)
                    && Objects.equal(tournaments, otherTab.tournaments)
                    && Objects.equal(id, otherTab.id)
                    && Objects.equal(label, otherTab.label);
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder()
                    .append(order)
                    .append(tournaments)
                    .append(id)
                    .append(label)
                    .toHashCode();
        }
    }

    public List<Tab> tabs;
    @SerializedName("contests_text")
    public String contestsText;

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other == null || !(other instanceof ContestRoot)) {
            return false;
        }
        ContestRoot otherContestRoot = (ContestRoot) other;
        return Objects.equal(contestsText, otherContestRoot.contestsText) && Objects.equal(tabs, otherContestRoot.tabs);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(tabs)
                .append(contestsText)
                .toHashCode();
    }
}
