package com.myticket.portfolio.dto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTests {
    @Test
    public void dtoTest(){
        String name = "hello";
        int age = 20;
        HelloResponseDto helloResponseDto = new HelloResponseDto(name,age);
        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getAge()).isEqualTo(age);
    }
}
