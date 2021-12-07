package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class GamesDaoImpl implements GamesDao{

        EntityManagerFactory emf;
        EntityManager em;

        public GamesDaoImpl(){
                emf = Persistence.createEntityManagerFactory("lab4");
                em =emf.createEntityManager();
        }


        @Override
        public void createGame(Games games) {
                em.getTransaction().begin();
                em.persist(games);
                em.getTransaction().commit();

        }

        @Override
        public List<Games> showAllGames() {
                TypedQuery<Games> query = em.createQuery("SELECT s FROM Games s", Games.class);
                return query.getResultList();
        }

        @Override
        public Games getGameById(int id) {
                return em.find(Games.class,id);
        }

        @Override
        public List<Games> upcomingGames(String releasedate) {
                TypedQuery<Games> query = em.createQuery("SELECT s from Games s where releasedate > :releasedate",Games.class);
                query.setParameter("releasedate", releasedate);
                return query.getResultList();

        }

        @Override
        public List<Games> getGamesByGenre(String genre) {
                TypedQuery<Games> query = em.createQuery("SELECT s FROM Games s where genre = :genre", Games.class);
                query.setParameter("genre", genre);
                return query.getResultList();
        }

        @Override
        public List<Games> getGamesPrice(int from, int to) {
                TypedQuery<Games> query = em.createQuery("SELECT s FROM Games s WHERE s.cost >:from AND s.cost < :to", Games.class);
                query.setParameter("from", from);
                query.setParameter("to",to);
                return query.getResultList();
        }

        @Override
        public List<Games> getGameDevelopedByOrganisation(String company) {
                TypedQuery<Games> query = em.createQuery("SELECT s FROM Games s Where s.company = :company",Games.class);
                query.setParameter("company", company);
                return query.getResultList();
        }

        @Override
        public List<Games> searchForAnything(String firstname) {
                TypedQuery<Games> query = em.createQuery("SELECT s FROM Games s Where CONCAT(s.firstname , s.genre, s.company, s.cost, s.releasedate) LIKE :firstname", Games.class);
                query.setParameter("firstname","%"+firstname+"%");
                return query.getResultList();
        }


}
