package dao;

import core.hero.Archer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArcherDao implements HeroDao<Archer> {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/rpg";
    private static final String SELECT_ALL = "SELECT * FROM \"Archer\"";
    private static final String SELECT_BY_ID = "SELECT * FROM Archer WHERE id = ?";
    private static final String SELECT_BY_NAME = "SELECT * FROM Archer WHERE name = ?";
    private static final String SAVE = "INSERT INTO \"Archer\" (name, health, damage) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE Archer SET name = ?, health = ?, damage = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM Archer WHERE id = ?";


    @Override
    public List<Archer> findAllHero() {
        List<Archer> archers = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DB_URL)) {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
            ResultSet result = ps.executeQuery();
            while(result.next()) {
                Archer a = new Archer();
                a.setId(result.getInt("id"));
                a.setName(result.getString("name"));
                a.setHealth(result.getFloat("health"));
                a.setDamage(result.getFloat("damage"));
                archers.add(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return archers;
    }

    @Override
    public Optional<Archer> findHeroById(Integer id) {
        try(Connection conn = DriverManager.getConnection(DB_URL)) {
            PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                Archer a = new Archer();
                a.setId(result.getInt("id"));
                a.setName(result.getString("name"));
                a.setHealth(result.getFloat("health"));
                a.setDamage(result.getFloat("damage"));
                return Optional.of(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Archer> findHeroByName(String name) {
        try(Connection conn = DriverManager.getConnection(DB_URL)) {
            PreparedStatement ps = conn.prepareStatement(SELECT_BY_NAME);
            ps.setString(1, name);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                Archer a = new Archer();
                a.setId(result.getInt("id"));
                a.setName(result.getString("name"));
                a.setHealth(result.getFloat("health"));
                a.setDamage(result.getFloat("damage"));
                return Optional.of(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void saveHero(Archer hero) {
        try(Connection conn = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            PreparedStatement ps = conn.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHealth());
            ps.setFloat(3, hero.getDamage());
            ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateHero(Archer hero) {
        try(Connection conn = DriverManager.getConnection(DB_URL)) {
            PreparedStatement ps = conn.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHealth());
            ps.setFloat(3, hero.getDamage());
            ps.setInt(4, hero.getId());
            ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteHero(Archer hero) {
        try(Connection conn = DriverManager.getConnection(DB_URL)) {
            PreparedStatement ps = conn.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, hero.getId());
            ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
