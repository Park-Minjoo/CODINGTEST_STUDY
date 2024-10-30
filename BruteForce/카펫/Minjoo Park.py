def solution(br, ye):
    ans = []
    ye_x = 0
    ye_y = 0
    for i in range(1, ye+1):
        if ye % i == 0:
            ye_x = ye // i
            ye_y = i
            if 2*ye_x + 2*ye_y + 4 == br:
                ans.append(ye_x+2)
                ans.append(ye_y+2)
                break
            ans.sort(reverse=True)
    return ans

