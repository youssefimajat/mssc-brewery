package guru.springframwork.msscbrewery.web.services;

import guru.springframwork.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updatedBeer(UUID beerId, BeerDto beerDto);
}
