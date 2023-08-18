package com.example.mockspace.common;

/**
 * Mapper类型，暂不设计批量转換
 * @author lanjzh
 * @param <TEntity> 领域实体
 * @param <TRequest> 客户端请求类型
 * @param <TResponse> 响应客户端返回类型
 */
public interface Mapper<TEntity, TRequest, TResponse> {

    /**
     * 客户端请求类型转为实体
     * @param request 客户端请求类型
     * @return 实体
     */
    TEntity fromRequest(TRequest request);

    /**
     * 实体转换为响应客户端类型
     * @param entity 实体
     * @return DTO/Response
     */
    TResponse toDto(TEntity entity);

    /**
     * 将所有request字段更新到实体中
     * @param request 客户端请求
     * @param entity 被更新的实体
     */
    TEntity updateByRequest(TRequest request, TEntity entity);
}
