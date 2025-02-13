package br.com.jota.entities;

import br.com.jota.entities.enums.GamesStatusEnum;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Board {
    private final List<List<Space>> spaces;

    public Board(List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    public GamesStatusEnum getStatus() {

        if (spaces.stream().flatMap(Collection::stream).noneMatch(s -> !s.isFixed() && Objects.nonNull(s.getActual())))
            return GamesStatusEnum.NON_STARTED;

        return spaces.stream().flatMap(Collection::stream).noneMatch(s -> Objects.isNull(s.getActual())) ? GamesStatusEnum.INCOMPLETE : GamesStatusEnum.COMPLETE;
    }

    public boolean hasErrors() {
        if (getStatus() == GamesStatusEnum.NON_STARTED)
            return false;

        return spaces.stream().flatMap(Collection::stream)
                .anyMatch(s -> Objects.nonNull(s.getActual()) && !s.getActual().equals(s.getExpected()));
    }

    public boolean changeValue(final Integer col, final Integer row, final Integer value) {
        var space = spaces.get(col).get(row);
        if (space.isFixed())
            return false;

        space.setActual(value);
        return true;
    }

    public boolean clearValue(final Integer col, final Integer row) {
        var space = spaces.get(col).get(row);
        if (space.isFixed())
            return false;

        space.clearSpace();
        return true;
    }

    public void reset() {
        spaces.forEach(c -> c.forEach(Space::clearSpace));
    }

    public boolean gameIsFinished(){
        return !hasErrors() && getStatus().equals(GamesStatusEnum.COMPLETE);
    }
}
