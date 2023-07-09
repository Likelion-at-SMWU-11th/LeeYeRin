from django.shortcuts import render
import random
# Create your views here.

def lotto(request):
    lotto_nubmer = list()
    for _ in range(7):
        lotto_nubmer.append(random.randint(1, 45))
        
    return render(request, 'lotto.html', {'lotto_number' : lotto_nubmer}) 