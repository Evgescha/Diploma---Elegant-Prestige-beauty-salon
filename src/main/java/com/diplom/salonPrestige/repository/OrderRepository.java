package com.diplom.salonPrestige.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diplom.salonPrestige.entity.Order;
import com.diplom.salonPrestige.entity.ServiceOrder;
import com.diplom.salonPrestige.entity.Status;
import com.diplom.salonPrestige.entity.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByCreator(User creator);

	List<Order> findByService(ServiceOrder service);

	List<Order> findByWorker(User worker);

	List<Order> findByStatus(Status status);
	
	Order findByCreatorAndServiceAndDateCreatedAndDateEnded(User creator,ServiceOrder service, Date dateCreated, Date dateEnded);
}
