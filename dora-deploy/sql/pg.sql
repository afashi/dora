/*
 Navicat Premium Data Transfer

 Source Server         : postgresql_dora
 Source Server Type    : PostgreSQL
 Source Server Version : 130004
 Source Host           : localhost:5432
 Source Catalog        : dora
 Source Schema         : dora

 Target Server Type    : PostgreSQL
 Target Server Version : 130004
 File Encoding         : 65001

 Date: 26/09/2021 15:41:26
*/


-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS "dora"."sys_menu";
CREATE TABLE "dora"."sys_menu" (
  "id" int8 NOT NULL,
  "parent_id" int8,
  "name" varchar(1024) COLLATE "pg_catalog"."default",
  "code" varchar(32) COLLATE "pg_catalog"."default",
  "sort" int2,
  "type" varchar(2) COLLATE "pg_catalog"."default",
  "hidden" varchar(1) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_time" timestamp(6)
)
;
COMMENT ON COLUMN "dora"."sys_menu"."id" IS 'id';
COMMENT ON COLUMN "dora"."sys_menu"."parent_id" IS '父id';
COMMENT ON COLUMN "dora"."sys_menu"."name" IS '菜单名称';
COMMENT ON COLUMN "dora"."sys_menu"."code" IS '编码';
COMMENT ON COLUMN "dora"."sys_menu"."sort" IS '排序';
COMMENT ON COLUMN "dora"."sys_menu"."type" IS '类型';
COMMENT ON COLUMN "dora"."sys_menu"."hidden" IS '是否隐藏';
COMMENT ON COLUMN "dora"."sys_menu"."create_time" IS '创建时间';
COMMENT ON COLUMN "dora"."sys_menu"."update_time" IS '更新时间';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "dora"."sys_role";
CREATE TABLE "dora"."sys_role" (
  "id" int8 NOT NULL,
  "code" varchar(32) COLLATE "pg_catalog"."default",
  "name" varchar(100) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_time" timestamp(6)
)
;
COMMENT ON COLUMN "dora"."sys_role"."id" IS 'id';
COMMENT ON COLUMN "dora"."sys_role"."code" IS '用户名';
COMMENT ON COLUMN "dora"."sys_role"."name" IS '密码';
COMMENT ON COLUMN "dora"."sys_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "dora"."sys_role"."update_time" IS '更新时间';

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS "dora"."sys_role_menu";
CREATE TABLE "dora"."sys_role_menu" (
  "id" int8 NOT NULL,
  "menu_id" int8,
  "role_id" int8,
  "create_time" timestamp(6),
  "update_time" timestamp(6)
)
;
COMMENT ON COLUMN "dora"."sys_role_menu"."id" IS 'id';
COMMENT ON COLUMN "dora"."sys_role_menu"."role_id" IS '密码';
COMMENT ON COLUMN "dora"."sys_role_menu"."create_time" IS '创建时间';
COMMENT ON COLUMN "dora"."sys_role_menu"."update_time" IS '更新时间';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "dora"."sys_user";
CREATE TABLE "dora"."sys_user" (
  "id" int8 NOT NULL,
  "username" varchar(100) COLLATE "pg_catalog"."default",
  "password" varchar(255) COLLATE "pg_catalog"."default",
  "nickname" varchar(255) COLLATE "pg_catalog"."default",
  "head_img_url" varchar(1024) COLLATE "pg_catalog"."default",
  "mobile" varchar(11) COLLATE "pg_catalog"."default",
  "sex" varchar(1) COLLATE "pg_catalog"."default",
  "enabled" varchar(1) COLLATE "pg_catalog"."default",
  "type" varchar(2) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "deleted" varchar(1) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "dora"."sys_user"."username" IS '用户名';
COMMENT ON COLUMN "dora"."sys_user"."password" IS '密码';
COMMENT ON COLUMN "dora"."sys_user"."nickname" IS '昵称';
COMMENT ON COLUMN "dora"."sys_user"."head_img_url" IS '头像地址';
COMMENT ON COLUMN "dora"."sys_user"."mobile" IS '手机号';
COMMENT ON COLUMN "dora"."sys_user"."sex" IS '性别';
COMMENT ON COLUMN "dora"."sys_user"."enabled" IS '是否启用';
COMMENT ON COLUMN "dora"."sys_user"."type" IS '类型';
COMMENT ON COLUMN "dora"."sys_user"."create_time" IS '创建时间';
COMMENT ON COLUMN "dora"."sys_user"."update_time" IS '更新时间';
COMMENT ON COLUMN "dora"."sys_user"."deleted" IS '是否删除';

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS "dora"."sys_user_role";
CREATE TABLE "dora"."sys_user_role" (
  "id" int8 NOT NULL,
  "user_id" int8,
  "role_id" int8,
  "create_time" timestamp(6),
  "update_time" timestamp(6)
)
;
COMMENT ON COLUMN "dora"."sys_user_role"."id" IS 'id';
COMMENT ON COLUMN "dora"."sys_user_role"."user_id" IS '用户名';
COMMENT ON COLUMN "dora"."sys_user_role"."role_id" IS '密码';
COMMENT ON COLUMN "dora"."sys_user_role"."create_time" IS '创建时间';
COMMENT ON COLUMN "dora"."sys_user_role"."update_time" IS '更新时间';

-- ----------------------------
-- Primary Key structure for table sys_menu
-- ----------------------------
ALTER TABLE "dora"."sys_menu" ADD CONSTRAINT "sys_menu_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE "dora"."sys_role" ADD CONSTRAINT "sys_role_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role_menu
-- ----------------------------
ALTER TABLE "dora"."sys_role_menu" ADD CONSTRAINT "sys_role_menu_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "dora"."sys_user" ADD CONSTRAINT "sys_user_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_user_role
-- ----------------------------
ALTER TABLE "dora"."sys_user_role" ADD CONSTRAINT "sys_role_user_pkey" PRIMARY KEY ("id");
