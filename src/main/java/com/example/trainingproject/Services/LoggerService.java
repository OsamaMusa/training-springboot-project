package com.example.trainingproject.Services;

import org.slf4j.*;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {
   static Logger logger = LoggerFactory.getLogger(LoggerService.class);
}
