package com.ubiblio.service;
import com.ubiblio.model.Buku;
import com.ubiblio.repository.BukuRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class BukuService {

    private final BukuRepository repository;

    public BukuService(BukuRepository repository) {
        this.repository = repository;
    }

    public List<Buku> tampilkan(String cari) {

        if (cari == null || cari.trim().isEmpty()) {
            return repository.findAll();
        }

        String keyword = cari.trim();

        return repository
            .findByJudulContainingIgnoreCaseOrPenulisContainingIgnoreCase(
                keyword, keyword
            );
    }

    public void tambah(Buku buku) {
        repository.save(buku);
    }

    public void edit(Buku buku) {
        if (!repository.existsById(buku.getIsbn())) {
            throw new RuntimeException("Data buku tidak ditemukan!");
        }

        repository.save(buku);
    }

    public void hapus(String isbn) {

        if (!repository.existsById(isbn)) {
            throw new RuntimeException("Data buku tidak ditemukan!");
        }

        repository.deleteById(isbn);
    }
}
