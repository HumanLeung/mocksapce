package com.example.mockspace.repository;

import com.example.mockspace.entity.DeliveryAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lanjzh
 */
@Repository
public interface DeliveryAssignmentRepository extends JpaRepository<DeliveryAssignment, String>,
        JpaSpecificationExecutor<DeliveryAssignment> {

}
