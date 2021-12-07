package org.example;

import java.util.List;

public interface GamesDao {

    void createGame(Games games);

    List<Games> showAllGames();

    Games  getGameById(int id);

    List<Games> upcomingGames(String releasedate);

    List<Games> getGamesByGenre(String genre);

    List<Games> getGamesPrice(int from, int to);

    List<Games> getGameDevelopedByOrganisation(String company );

    List<Games> searchForAnything(String firstname);



}
