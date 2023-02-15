package com.spring.main.repository;

import com.spring.main.entity.PurchaseCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseCourseRepository extends JpaRepository<PurchaseCourse, Integer> {
    @Query(value = "SELECT COUNT(purchase_course_id) AS total FROM purchase_course pc WHERE pc.p_course_id =:purchaseCourseId", nativeQuery = true)
    Integer countAll(@Param("purchaseCourseId") int id);

    @Query(value = "SELECT SUM(purchase_course_price) AS price FROM purchase_course pc WHERE pc.p_course_id =:purchaseCourseId", nativeQuery = true)
    Integer totalPrice(@Param("purchaseCourseId") int id);
}
