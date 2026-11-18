package com.ubiblio.repository;

import com.ubiblio.model.Buku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BukuRepository
        extends JpaRepository<Buku, String> {

    List<Buku>
    findByJudulContainingIgnoreCaseOrPenulisContainingIgnoreCase(
        String judul, String penulis
    );
}

