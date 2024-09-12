package controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.PhonebookVO;

@Service
public class PhonebookService {

    @Autowired
    private PhonebookDAO phonebookDAO;

    public void insert(PhonebookVO phonebook) {
        phonebookDAO.insert(phonebook);
    }

    public List<Map<String, Object>> selectAll() {
        return phonebookDAO.selectAll();
    }

    public List<Map<String, Object>> search(String keyword) {
        return phonebookDAO.search(keyword);
    }

    public Map<String, Object> selectById(int id) {
        return phonebookDAO.selectById(id);
    }

    public void update(PhonebookVO phonebook) {
        phonebookDAO.update(phonebook);
    }
}
