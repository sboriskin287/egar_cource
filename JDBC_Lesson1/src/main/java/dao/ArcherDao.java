package dao;

import entity.ArcherEntity;
import entity.HeroEntity;
import entity.ItemEntity;
import entity.ItemType;

import javax.sql.RowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ArcherDao implements HeroDao<ArcherEntity> {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/rpg";
    private static final String SELECT_ALL = "SELECT a.id, h.name, h.health, h.damage FROM archer a " +
            "JOIN hero h ON a.hero_id = h.id";
    private static final String SELECT_ITEMS = "SELECT * FROM item i " +
            "WHERE i.hero_id = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM Archer WHERE id = ?";
    private static final String SELECT_BY_NAME = "SELECT * FROM Archer WHERE name = ?";
    private static final String SAVE = "INSERT INTO archer (hero_id) VALUES (?)";
    private static final String SAVE_HERO = "INSERT INTO hero (name, health, damage) VALUES (?,?,?)";


    private static final String SAVE_ITEMS =
            "INSERT INTO items (type, value, hero_id) " +
                    "VALUES (?, ?, ?)";
    private static final String SAVE_TASKS =
            "INSERT INTO items (name, award, location_id) " +
                    "VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE Archer SET name = ?, health = ?, damage = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM Archer WHERE id = ?";
    private static ArcherDao instance;

    public static ArcherDao getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ArcherDao();
        }
        return instance;
    }

    private ArcherDao() {}

    @Override
    public List<ArcherEntity> findAllHero() {
        List<ArcherEntity> archers = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            Statement psa = conn.createStatement();
            ResultSet ra = psa.executeQuery(SELECT_ALL);
            while(ra.next()) {
                ArcherEntity a = new ArcherEntity();
                HeroEntity h = new HeroEntity();
                a.setId(ra.getInt("id"));
                h.setName(ra.getString("name"));
                h.setHealth(ra.getFloat("health"));
                h.setDamage(ra.getFloat("damage"));
                a.setHero(h);
                PreparedStatement psi =
                        conn.prepareStatement(SELECT_ITEMS);
                psi.setInt(1, a.getId());
                ResultSet rsi = psi.executeQuery();
                List<ItemEntity> items = new ArrayList<>();
                while (rsi.next()) {
                    ItemEntity i = new ItemEntity();
                    i.setId(rsi.getInt("id"));
                    i.setValue(rsi.getInt("value"));
                    i.setType(ItemType.getByType(rsi.getInt("type")));
                    i.setHero(h);
                    items.add(i);
                }
                h.setItems(items);
                archers.add(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return archers;
    }

    @Override
    public Optional<ArcherEntity> findHeroById(Integer id) {
        try(Connection conn = DriverManager.getConnection(DB_URL)) {
            PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                ArcherEntity a = new ArcherEntity();
                HeroEntity h = new HeroEntity();
                a.setId(result.getInt("id"));
                h.setName(result.getString("name"));
                h.setHealth(result.getFloat("health"));
                h.setDamage(result.getFloat("damage"));
                a.setHero(h);
                return Optional.of(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<ArcherEntity> findHeroByName(String name) {
        try(Connection conn = DriverManager.getConnection(DB_URL)) {
            PreparedStatement ps = conn.prepareStatement(SELECT_BY_NAME);
            ps.setString(1, name);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                ArcherEntity a = new ArcherEntity();
                HeroEntity h = new HeroEntity();
                a.setId(result.getInt("id"));
                h.setName(result.getString("name"));
                h.setHealth(result.getFloat("health"));
                h.setDamage(result.getFloat("damage"));
                a.setHero(h);
                return Optional.of(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void saveHero(ArcherEntity hero) {
        try(Connection conn = DriverManager.getConnection(DB_URL, "postgres", "postgres")) {
            PreparedStatement psa = conn.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS);
            psa.setInt(1, hero.getHero().getId());
            psa.execute();
            PreparedStatement psh = conn.prepareStatement(SAVE_HERO);
            psh.setString(1, hero.getHero().getName());
            psh.setFloat(2, hero.getHero().getHealth());
            psh.setFloat(3, hero.getHero().getDamage());
            psh.execute();
            hero.getHero().getItems()
                    .forEach(i -> {
                        try {
                            PreparedStatement psi = conn.prepareStatement(SAVE_ITEMS);
                            psi.setInt(1, i.getType().getType());
                            psi.setInt(2, i.getValue());
                            psi.setInt(1, i.getHero().getId());
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateHero(ArcherEntity hero) {
        /*try(Connection conn = DriverManager.getConnection(DB_URL)) {
            PreparedStatement ps = conn.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, hero.getName());
            ps.setFloat(2, hero.getHealth());
            ps.setFloat(3, hero.getDamage());
            ps.setInt(4, hero.getId());
            ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }

    @Override
    public void deleteHero(ArcherEntity hero) {
        /*try(Connection conn = DriverManager.getConnection(DB_URL)) {
            PreparedStatement ps = conn.prepareStatement(DELETE, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, hero.getId());
            ps.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }
}
