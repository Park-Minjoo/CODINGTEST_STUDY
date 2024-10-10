class LeeMoonGi {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int castingTime = bandage[0]; // 시전 시간
        int secRecovery = bandage[1]; // 초당 회복량
        int bonausRecovery = bandage[2]; // 추가 회복량

        int castingTimer = 0;

        int loof = 0;
        int maxTime = attacks.length;
        int curHealth = health;

        // 루프 최대값 구하기
        for (int i=0; i<maxTime; i++) {
            loof = Math.max(loof, attacks[i][0]);
        }

        int attackIdx = 0;
        int[] attack;

        for (int i=1; i<=loof; i++) {
            attack = attacks[attackIdx];

            // 공격 당함
            if (attack[0] == i) {
                curHealth -= attack[1];
                // 사망
                if (curHealth < 0) {
                    return -1;
                }
                attackIdx++;
                castingTimer = 0;
            } else {
                // 회복
                int recovery = secRecovery;
                castingTimer++;
                if (castingTimer == castingTime) {
                    recovery += bonausRecovery;
                    castingTimer = 0;
                }

                if (curHealth + recovery >= health) {
                    curHealth = health;
                } else {
                    curHealth += recovery;
                }

            }
        }

        int answer = curHealth;
        if (answer == 0) answer =-1;
        return answer;
    }

    private static void print(int n) {
        System.out.println(n);
    }
}