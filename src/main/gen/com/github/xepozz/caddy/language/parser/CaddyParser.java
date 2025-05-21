// This is a generated file. Not intended for manual editing.
package com.github.xepozz.caddy.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.xepozz.caddy.language.psi.CaddyTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class CaddyParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return caddyFile(b, l + 1);
  }

  /* ********************************************************** */
  // IDENTIFIER | TEXT
  static boolean address(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "address")) return false;
    if (!nextTokenIs(b, "", IDENTIFIER, TEXT)) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, TEXT);
    return r;
  }

  /* ********************************************************** */
  // simple_value | env_value
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = simple_value(b, l + 1);
    if (!r) r = env_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACE EOL instructions RBRACE
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BLOCK, "<block>");
    r = consumeTokens(b, 2, LBRACE, EOL);
    p = r; // pin = 2
    r = r && report_error_(b, instructions(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, CaddyParser::block_recover);
    return r || p;
  }

  /* ********************************************************** */
  // (LPAREN address RPAREN) | address
  public static boolean block_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_NAME, "<block name>");
    r = block_name_0(b, l + 1);
    if (!r) r = address(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN address RPAREN
  private static boolean block_name_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_name_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && address(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(COMMENT | IDENTIFIER | RBRACE | EOL)
  static boolean block_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !block_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMENT | IDENTIFIER | RBRACE | EOL
  private static boolean block_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_recover_0")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean caddyFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caddyFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caddyFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER argument* block?
  public static boolean directive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DIRECTIVE, "<directive>");
    r = consumeToken(b, IDENTIFIER);
    p = r; // pin = 1
    r = r && report_error_(b, directive_1(b, l + 1));
    r = p && directive_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, CaddyParser::directive_recover);
    return r || p;
  }

  // argument*
  private static boolean directive_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argument(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "directive_1", c)) break;
    }
    return true;
  }

  // block?
  private static boolean directive_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_2")) return false;
    block(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !(COMMENT | IDENTIFIER | EOL)
  static boolean directive_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !directive_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMENT | IDENTIFIER | EOL
  private static boolean directive_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "directive_recover_0")) return false;
    boolean r;
    r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, EOL);
    return r;
  }

  /* ********************************************************** */
  // LBRACE (TEXT|IDENTIFIER) RBRACE
  public static boolean env_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "env_value")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENV_VALUE, null);
    r = consumeToken(b, LBRACE);
    r = r && env_value_1(b, l + 1);
    p = r; // pin = 2
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // TEXT|IDENTIFIER
  private static boolean env_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "env_value_1")) return false;
    boolean r;
    r = consumeToken(b, TEXT);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // directive | COMMENT
  public static boolean instruction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instruction")) return false;
    if (!nextTokenIs(b, "<instruction>", COMMENT, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INSTRUCTION, "<instruction>");
    r = directive(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (instruction? EOL)*
  static boolean instructions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instructions")) return false;
    while (true) {
      int c = current_position_(b);
      if (!instructions_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "instructions", c)) break;
    }
    return true;
  }

  // instruction? EOL
  private static boolean instructions_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instructions_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = instructions_0_0(b, l + 1);
    r = r && consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  // instruction?
  private static boolean instructions_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instructions_0_0")) return false;
    instruction(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // named_block | block | COMMENT | EOL
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = named_block(b, l + 1);
    if (!r) r = block(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, EOL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // block_name block
  public static boolean named_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_block")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMED_BLOCK, "<named block>");
    r = block_name(b, l + 1);
    r = r && block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TEXT | NUMBER | IDENTIFIER
  public static boolean simple_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIMPLE_VALUE, "<simple value>");
    r = consumeToken(b, TEXT);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
