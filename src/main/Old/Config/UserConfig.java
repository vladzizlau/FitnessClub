package by.pvt.core.config;

import by.pvt.core.repository.*;
import by.pvt.core.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan("by.pvt.core")
//public class UserConfig {
//    @Bean
//    public UserService userService() {
//        return new UserService(dbUserRepoHibernate());
//    }
//    @Bean
//    public WorkersService workersService() {
//        return new WorkersService(dbWorkersRepoHibernate());
//    }
//    @Bean
//    public GuestService guestService() {
//        return new GuestService(dbGuestRepoHibernate());
//    }
//    @Bean
//    public OfferService offerService() {
//        return new OfferService(dbOfferRepoHibernate());
//    }
//    @Bean
//    public OfficeService officeService() {
//        return new OfficeService(dbOfficeRepoHibernate());
//    }
//
//    @Bean
//    public DBUserRepoHibernate dbUserRepoHibernate() {
//        return new DBUserRepoHibernate();
//    }
//
//    @Bean
//    public DBWorkersRepoHibernate dbWorkersRepoHibernate() {
//        return new DBWorkersRepoHibernate();
//    }
//
//    @Bean
//    public DBGuestRepoHibernate dbGuestRepoHibernate() {
//        return new DBGuestRepoHibernate();    }
//
//    @Bean
//    public DBOfferRepoHibernate dbOfferRepoHibernate() {
//        return new DBOfferRepoHibernate();
//    }
//
//
//    @Bean
//    public DBOfficeRepoHibernate dbOfficeRepoHibernate() {
//        return new DBOfficeRepoHibernate();
//    }
//}
