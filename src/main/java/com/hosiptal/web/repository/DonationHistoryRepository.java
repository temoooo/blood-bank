package com.hosiptal.web.repository;

import com.hosiptal.web.models.DonateHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonationHistoryRepository extends JpaRepository<DonateHistory,Long> {
    List<DonateHistory> findByDownerId(Long id);
}
