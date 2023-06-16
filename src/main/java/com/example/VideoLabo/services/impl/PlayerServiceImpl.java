package com.example.VideoLabo.services.impl;

import com.example.VideoLabo.entities.PlayerEntity;
import com.example.VideoLabo.models.Player;
import com.example.VideoLabo.repositories.jpa.PlayerJpaRepository;
import com.example.VideoLabo.services.PlayerService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {


    @Autowired
    private PlayerJpaRepository playerJpaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Player playerByID(Long id) {
        PlayerEntity playerEntity = playerJpaRepository.getReferenceById(id);
        Player player = modelMapper.map(playerEntity, Player.class);
        return player;
    }

    @Override
    public Player savePlayer(Player player) {

        Optional<PlayerEntity> playerEntityOptional = playerJpaRepository.findByUserNameOrEmail(player.getUserName(), player.getEmail());

        if(playerEntityOptional.isEmpty()){
            PlayerEntity playerEntity = modelMapper.map(player,PlayerEntity.class);
            PlayerEntity playerEntitySaved = playerJpaRepository.save(playerEntity);
            return modelMapper.map(playerEntitySaved, Player.class);
        }
        return null;
    }
}
