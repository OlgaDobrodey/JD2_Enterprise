package by.it_academy.jd2.config;


import by.it_academy.jd2.core.service.*;
import by.it_academy.jd2.core.service.api.*;
import by.it_academy.jd2.storage.api.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.config.IsNewAwareAuditingHandlerBeanDefinitionParser;


@Configuration
@ComponentScan("by.it_academy.jd2.config")
public class RootConfig {


    @Bean
    public IUserView userView(IUserRepository repository) {
        return new UserView(repository);
    }

    @Bean
    public IPassportView passportView(IPassportRepository repository) {
        return new PassportView(repository);
    }

    @Bean
    public IAddressView addressView(IAddressRepository repository) {
        return new AddressView(repository);
    }

    @Bean
    public IMessageView messageView(IMessageRepository repository) {
        return new MessageView(repository);
    }

    @Bean
    public IMedicalCardView medicalCardView(IMedicalCardRepository repository, IDiagnosisRepository diagnosisRepository) {
        return new MedicalCardView(repository, diagnosisRepository);
    }

    @Bean
    public IDiagnosisView diagnosisView(IDiagnosisRepository repository) {
        return new DiagnosisView(repository);
    }

    @Bean
    public IDepartementView departementView(IDepartamentRepository repository) {
        return new DepartamentView(repository);
    }

}
