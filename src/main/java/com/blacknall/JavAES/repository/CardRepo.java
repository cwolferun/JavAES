package com.blacknall.JavAES.repository;

import com.blacknall.JavAES.model.Postcard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo extends JpaRepository<Postcard, String> {



}
