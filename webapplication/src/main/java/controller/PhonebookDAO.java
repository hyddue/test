package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import model.PhonebookVO;

@Repository
public class PhonebookDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbc;

    public void insert(PhonebookVO phonebook) {
        String sql = "INSERT INTO phonebook (id, name, hp, memo) VALUES (phonebook_id_seq.NEXTVAL, :name, :hp, :memo)";
        Map<String, Object> map = new HashMap<>();
        map.put("name", phonebook.getName());
        map.put("hp", phonebook.getHp());
        map.put("memo", phonebook.getMemo());

        jdbc.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

    public List<Map<String, Object>> selectAll() {
        String sql = "SELECT * FROM phonebook";
        return jdbc.execute(sql, new HashMap<>(), new PreparedStatementCallback<List<Map<String, Object>>>() {
            @Override
            public List<Map<String, Object>> doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.execute();
                return ps.getResultSet().unwrap(List.class); 
            }
        });
    }

    public List<Map<String, Object>> search(String keyword) {
        String sql = "SELECT * FROM phonebook WHERE name LIKE :keyword OR hp LIKE :keyword OR memo LIKE :keyword";
        Map<String, Object> map = new HashMap<>();
        map.put("keyword", "%" + keyword + "%");

        return jdbc.execute(sql, map, new PreparedStatementCallback<List<Map<String, Object>>>() {
            @Override
            public List<Map<String, Object>> doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.execute();
                return ps.getResultSet().unwrap(List.class); 
            }
        });
    }

    public Map<String, Object> selectById(int id) {
        String sql = "SELECT * FROM phonebook WHERE id = :id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        return jdbc.execute(sql, map, new PreparedStatementCallback<Map<String, Object>>() {
            @Override
            public Map<String, Object> doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.execute();
                return ps.getResultSet().unwrap(Map.class); 
            }
        });
    }

    public void update(PhonebookVO phonebook) {
        String sql = "UPDATE phonebook SET name = :name, hp = :hp, memo = :memo WHERE id = :id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", phonebook.getId());
        map.put("name", phonebook.getName());
        map.put("hp", phonebook.getHp());
        map.put("memo", phonebook.getMemo());

        jdbc.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }
}
