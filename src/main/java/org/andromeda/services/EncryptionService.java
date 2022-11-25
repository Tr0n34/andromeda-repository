package org.andromeda.services;

import org.springframework.stereotype.Service;

@Service
public interface EncryptionService {

    void encrypt(String data);

    String decrypt(String data);

}
