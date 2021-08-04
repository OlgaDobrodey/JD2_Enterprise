package by.it_academy.jd2.config;


import by.it_academy.jd2.core.service.api.chat.IMessageView;
import by.it_academy.jd2.core.service.api.medical.IDepartementView;
import by.it_academy.jd2.core.service.api.medical.IDiagnosisView;
import by.it_academy.jd2.core.service.api.medical.IMedicalCardView;
import by.it_academy.jd2.core.service.api.people.IAddressView;
import by.it_academy.jd2.core.service.api.people.IPassportView;
import by.it_academy.jd2.core.service.api.people.IUserView;
import by.it_academy.jd2.core.service.chat.MessageView;
import by.it_academy.jd2.core.service.medical.DepartamentView;
import by.it_academy.jd2.core.service.medical.DiagnosisView;
import by.it_academy.jd2.core.service.medical.MedicalCardView;
import by.it_academy.jd2.core.service.people.AddressView;
import by.it_academy.jd2.core.service.people.PassportView;
import by.it_academy.jd2.core.service.people.UserView;
import by.it_academy.jd2.storage.api.chat.IMessageRepository;
import by.it_academy.jd2.storage.api.medicalCard.IDepartamentRepository;
import by.it_academy.jd2.storage.api.medicalCard.IDiagnosisRepository;
import by.it_academy.jd2.storage.api.medicalCard.IMedicalCardRepository;
import by.it_academy.jd2.storage.api.people.IAddressRepository;
import by.it_academy.jd2.storage.api.people.IPassportRepository;
import by.it_academy.jd2.storage.api.people.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


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
    public IAddressView addressView(IAddressRepository repository, IUserRepository userRepository) {
        return new AddressView(repository, userRepository);
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
