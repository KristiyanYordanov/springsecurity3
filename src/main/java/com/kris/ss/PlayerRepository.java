package com.kris.ss;

import java.util.List;


public interface PlayerRepository {//extends CrudRepository<Player, Long> {

    List<Player> findByName(String name);
}