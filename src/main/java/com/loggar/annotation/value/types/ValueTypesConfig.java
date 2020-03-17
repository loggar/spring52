package com.loggar.annotation.value.types;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

enum Designation {
	MANAGER, DEVELOPER, TESTER;
}

@Configuration
public class ValueTypesConfig {
	// cp.user.active=true
	@Value("${cp.user.active}") private Boolean isUserActive;
	@Value("${cp.user.active:true}") private Boolean isUserActiveWithDefault;

	// cp.user.age=50
	@Value("${cp.user.age}") private Integer userAge;
	@Value("${cp.user.age:30}") private Integer userAgeWithDefault;

	// cp.user.skills=Java, Spring, Angular
	@Value("${cp.user.skills}") private String[] userSkills;
	@Value("${cp.user.skills:Java,Spring,Angular}") private String[] userSkillsWithDefault;

	// cp.user.skillids=1,2,3
	@Value("${cp.user.skillids:5,6,7}") private int[] userSkillIds;

	@Value("#{'${cp.user.skills}'.split(',')}") private List<String> userSkillsList;
	@Value("#{'${cp.user.skills:Java,HTML,Spring}'.split(',')}") private List<String> userSkillsWithDefatult;

	// cp.user.teamMates={100: 'Krishna', 200: 'Shiva'}
	@Value("#{${cp.user.teamMates}}") private Map<Integer, String> teamMates;
	@Value("#{${cp.user.teamMates: {100: 'Krishna', 200: 'Shiva'}}}") private Map<Integer, String> teamMatesWithDefault;

	// cp.user.designation=DEVELOPER
	@Value("${cp.user.designation}") protected Designation designation;
}
