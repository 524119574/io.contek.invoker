package io.contek.invoker.deribit.api.rest.user;

import com.google.common.collect.ImmutableList;
import io.contek.invoker.commons.actor.IActor;
import io.contek.invoker.commons.actor.ratelimit.RateLimitQuota;
import io.contek.invoker.commons.rest.RestContext;
import io.contek.invoker.commons.rest.RestMethod;
import io.contek.invoker.commons.rest.RestParams;
import io.contek.invoker.deribit.api.common.constants._AccountSummary;
import io.contek.invoker.deribit.api.rest.common.RestResponse;

import javax.annotation.concurrent.NotThreadSafe;

import static io.contek.invoker.commons.rest.RestMethod.GET;
import static io.contek.invoker.deribit.api.ApiFactory.RateLimits.ONE_NON_MATCHING_ENGINE_REQUEST;
import static java.util.Objects.requireNonNull;

public class GetAccountSummary extends UserRestRequest<GetAccountSummary.Response> {
  private String currency;
  private Boolean extended;

  GetAccountSummary(IActor actor, RestContext context) {
    super(actor, context);
  }

  public GetAccountSummary setCurrency(String currency) {
    this.currency = currency;
    return this;
  }

  public GetAccountSummary setExtended(boolean extended) {
    this.extended = extended;
    return this;
  }

  @Override
  protected RestMethod getMethod() {
    return GET;
  }

  @Override
  protected String getEndpointPath() {
    return "/api/v2/private/get_account_summary";
  }

  @Override
  protected RestParams getParams() {
    RestParams.Builder builder = RestParams.newBuilder();

    requireNonNull(currency);
    builder.add("currency", currency);

    if (extended != null) {
      builder.add("extended", extended);
    }

    return builder.build();
  }

  @Override
  protected ImmutableList<RateLimitQuota> getRequiredQuotas() {
    return ONE_NON_MATCHING_ENGINE_REQUEST;
  }

  @Override
  protected Class<Response> getResponseType() {
    return Response.class;
  }

  @NotThreadSafe
  public static final class Response extends RestResponse<_AccountSummary> {
  }
}