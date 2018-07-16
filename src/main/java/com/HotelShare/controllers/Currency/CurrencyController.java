/*
package com.HotelShare.controllers.Currency;

import com.HotelShare.entities.Address.AddressAdapter;
import com.HotelShare.entities.Address.AddressDTO;
import com.HotelShare.entities.Country.Country;
import com.HotelShare.entities.Country.CountryAdapter;
import com.HotelShare.entities.Country.CountryDTO;
import com.HotelShare.entities.Currency.Currency;
import com.HotelShare.entities.Currency.CurrencyAdapter;
import com.HotelShare.entities.Currency.CurrencyDTO;
import com.HotelShare.entities.UserProfile.UserProfileAdapter;
import com.HotelShare.entities.UserProfile.UserProfileDTO;
import com.HotelShare.exceptions.NotFoundException;
import com.HotelShare.repositories.Currency.CurrencyRepository;
import com.HotelShare.repositories.UserProfile.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Transactional
    @GetMapping()
    public Page<CurrencyDTO> getAllCurrencies(@PageableDefault(value = 250) Pageable pageable) {
        return currencyRepository.findAll(pageable).map(CurrencyAdapter::toCurrencyDTO);
    }

    @Transactional
    @GetMapping("/{currencyId}/userProfiles")
    public Page<UserProfileDTO> getAllUserProfilessByCurrencyId(@PathVariable(value = "currencyId") Long currencyId,
                                                                Pageable pageable) {
        return userProfileRepository.findByCurrencyId(currencyId, pageable).map(UserProfileAdapter::toUserProfileDTO);
    }

    @Transactional
    @GetMapping("/{currencyId}")
    public CurrencyDTO getCurrencyById(@PathVariable Long currencyId) {
        return CurrencyAdapter.toCurrencyDTO(currencyRepository.getOne(currencyId));
    }

    @Transactional
    @PostMapping()
    public CurrencyDTO createCurrency(@Valid @RequestBody CurrencyDTO currencyDTO) {
        return CurrencyAdapter.toCurrencyDTO(currencyRepository.save(CurrencyAdapter.toCurrency(currencyDTO)));
    }

    @Transactional
    @PutMapping("/{currencyId}")
    public CurrencyDTO updateCurrency(@PathVariable Long currencyId, @Valid @RequestBody Currency currencyRequest) {
        return currencyRepository.findById(currencyId).map(currency -> {
            currency.setNameCurrency(currencyRequest.getNameCurrency());
            currency.setUserProfiles(currencyRequest.getUserProfiles());
            currency.setUpdatedDate(currencyRequest.getUpdatedDate());
            return CurrencyAdapter.toCurrencyDTO(currencyRepository.save(currency));
        }).orElseThrow(() -> new NotFoundException("CurrencyId " + currencyId + " not found"));
    }

    @Transactional
    @DeleteMapping("/{currencyId}")
    public ResponseEntity<?> deleteCurrency(@PathVariable Long currencyId) {
        return currencyRepository.findById(currencyId).map(currency -> {
            currencyRepository.delete(currency);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("CurrencyId " + currencyId + " not found"));
    }


}

*/
