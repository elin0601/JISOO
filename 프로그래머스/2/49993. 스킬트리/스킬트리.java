class Solution {
    public int solution(String skill, String[] skill_trees) {
       int count = 0;

        for (String skillTree : skill_trees) {
            if (isValidSkillTree(skill, skillTree)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValidSkillTree(String skill, String skillTree) {
        int skillIndex = 0;

        for (int i = 0; i < skillTree.length(); i++) {
            char currentSkill = skillTree.charAt(i);
            int indexInSkill = skill.indexOf(currentSkill);

            if (indexInSkill == -1) {
                continue;
            }

            if (indexInSkill == skillIndex) {
                skillIndex++;
            } else {
                return false;
            }
        }

        return true;
    }
}