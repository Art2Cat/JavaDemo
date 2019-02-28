package com.art2cat.dev.jpademo.models;


import java.util.Objects;
import java.util.StringJoiner;

/**
 * @author rorschach.h
 */
public class Team extends Organization {

    private String teamCode;

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Team team = (Team) o;
        return Objects.equals(teamCode, team.teamCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), teamCode);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Team.class.getSimpleName() + "[", "]")
            .add("teamCode='" + teamCode + "'")
            .add("id=" + id)
            .add("name='" + name + "'")
            .add("phone='" + phone + "'")
            .add("fax='" + fax + "'")
            .toString();
    }
}
