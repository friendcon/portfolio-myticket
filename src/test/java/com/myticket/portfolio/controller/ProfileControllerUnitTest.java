package com.myticket.portfolio.controller;

import com.myticket.portfolio.controller.view.ProfileController;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.AssertionsForClassTypes.setRemoveAssertJRelatedElementsFromStackTrace;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ProfileControllerUnitTest {
    @Test
    public void real_profile_조회() {
        // real과 real-db profile 활성화된 상태
        String expectedProfile = "real";
        MockEnvironment environment = new MockEnvironment();
        environment.addActiveProfile(expectedProfile);
        environment.addActiveProfile("real-db");
        ProfileController controller = new ProfileController(environment);

        String profile = controller.profile();
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void real_profile_없으면첫번째조회회() {
        // 실행중인 profile은 realdb와 oauth
        String expectedProfile = "oauth";
        MockEnvironment environment = new MockEnvironment();
        environment.addActiveProfile(expectedProfile);
        environment.addActiveProfile("real-db");
        ProfileController controller = new ProfileController(environment);

        // 컨트롤러에서 활성화된 profile을 가져와서 oauth 활성화되어있는지 확인
        String profile = controller.profile();
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void active_profile_없으면_default조회() {
        String expectedProfile = "default";
        MockEnvironment environment = new MockEnvironment();
        ProfileController controller = new ProfileController(environment);
        String profile = controller.profile();
        assertThat(profile).isEqualTo(expectedProfile);
    }
}
