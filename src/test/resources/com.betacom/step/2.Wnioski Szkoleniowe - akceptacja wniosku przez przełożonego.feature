#language: pl
@Run
  Funkcja: Akceptacja wniosku szkoleniowego jako przełożony
    Jako przełożony w platformie e-learningowej Orange
    Posiadając wniosek szkoleniowy złożony przez mojego pracownika
    Chcę zaakceptować wniosek
    W celu przesłania go do dalszej akceptacji

#    @ManagerWnioski
  Scenariusz: Przełożony wyszukuje istniejący wniosek szkoleniowy pracownika do akceptacji
    Zakładając że jestem zalogowany jako "managerwnioski"
    Zakładając że posiadam przynajmniej jeden wniosek do akceptacji
    Oraz znajduje się na stronie akceptacji wniosków przez przełożonego
    Kiedy uzupełnie formularz wyszukiwania wniosku do akceptacji jako przełożony
    I nacisnę przycisk "Wyszukaj"
    Wtedy powinienem wyszukać formularz podwładnego do akceptacji

  Scenariusz: Przełożony wchodzi w szczegóły wniosku szkoleniowego pracownika do akceptacji
    Zakładając że wyszukałem interesujący mnie szablon do akceptacji
    Oraz nacisnę przycisk "Szczegóły"
    Wtedy powinienem zobaczyć szczegóły wniosku szkoleniowego swojego podwładnego do akceptacji

#  @Anuluj
  Scenariusz: Przełożony akceptuje wniosek szkoleniowy przesłany przez pracownika
    I nacisnę przycisk "Anuluj"
    Zakładając że wyszukałem interesujący mnie szablon do akceptacji
    Oraz nacisnę przycisk "Akceptuj"
    Wtedy powinienem zobaczyć potwierdzenie wysłania wniosku szkoleniowego podwładnego do dalszej akceptacji