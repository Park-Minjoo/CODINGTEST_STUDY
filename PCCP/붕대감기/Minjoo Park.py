def solution(bandage, health, attacks):
    answer = health

    i = 1
    skill = 0

    while len(attacks) > 0:
        if i == attacks[0][0]:
            answer -= attacks[0][1]
            skill = 0
            attacks.pop(0)
            if answer <= 0:
                answer = -1
                break
        else:
            answer += bandage[1]
            if answer >= health:
                answer = health
            skill += 1
            if skill == bandage[0]:
                answer += bandage[2]
                if answer >= health:
                    answer = health
                skill = 0
        i += 1

    return answer

