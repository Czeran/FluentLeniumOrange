#language: pl
@Run
  Funkcja: Przekazanie wniosku szkoleniowego do akceptacji
    Jako użytkownik platformy e-lerningowej Orange
    Na podstawie szablonu wniosku szkoleniowego
    Chcę utworzyć nowy wniosek szkoleniowy
    W celu przesłania go do dalszej akceptacji

    @UżytkownikWnioski
  Scenariusz: Użytkownik wyszukuje istniejący szablon wniosku szkoleniowego
    Zakładając że jestem na stronie wyszukiwania szablonu wniosku szkoleniowego
    Oraz uzupełnię formularz wyszukiwania szablonu wniosku szkoleniowego
    I nacisnę przycisk "Wyszukaj"
    Wtedy wyszukam interesujący mnie szablon

  Scenariusz: Użytkownik wyświetla nowy formularza wniosku szkoleniowego
    Zakładając że wyszukałem interesujący mnie szablon
    I nacisnę przycisk "Nowy wniosek"
    Wtedy wyświetli mi się formularz nowego wniosku szkoleniowego

  Scenariusz: Użytkownik tworzy nowy wniosek szkoleniowy
    Zakładając że jestem na stronie z formularzem nowego wniosku szkoleniowego
    Oraz uzupełnię formularz tworzenia nowego wniosku szkoleniowego
    I nacisnę przycisk "Zapisz"
    Wtedy powinienem zobaczyć potwierdzenie stworzenia nowego wniosku szkoleniowego

    @Wyloguj
  Scenariusz: Użytkownik wysyła utworzony wniosek szkoleniowy do akcpetacji
    Zakładając że jestem na stronie z utworzonym wnioskiem szkoleniowym
    Oraz nacisnę przycisk "Prześlij do akceptacji"
    Wtedy powinienem zobaczyć potwierdzenie wysłania wniosku szkoleniowego do ackeptacji
