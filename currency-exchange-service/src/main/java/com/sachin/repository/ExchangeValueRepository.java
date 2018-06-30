package com.sachin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sachin.model.ExchangeValue;

@Repository
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(String from, String to);
    
    public static final String FIND_PROJECTS = "select v FROM ExchangeValue v where v.from = :from and v.to=:to";

    @Query(value = FIND_PROJECTS)
    public ExchangeValue findUsingHQL(@Param(value = "from") String from, @Param(value = "to") String to);
}
