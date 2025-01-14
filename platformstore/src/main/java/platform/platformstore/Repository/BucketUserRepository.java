package platform.platformstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import platform.platformstore.Models.BucketUser;


public interface BucketUserRepository extends JpaRepository<BucketUser, Long> {

}
