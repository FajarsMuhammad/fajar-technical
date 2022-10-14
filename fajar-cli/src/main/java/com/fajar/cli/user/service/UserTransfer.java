package com.fajar.cli.user.service;

import com.fajar.cli.user.payload.request.TransferRequest;
import com.fajar.cli.user.payload.response.TransferResponse;

public interface UserTransfer {

    TransferResponse transfer(TransferRequest request);
}
